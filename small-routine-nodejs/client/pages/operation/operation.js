// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId: undefined,
    areaName: '',
    priority: '',
    addUrl: 'http://www.wpd.com/darren/addArea',
    updateUrl: 'http://www.wpd.com/darren/modifyArea'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    this.setData({
      areaId: options.areaId
    });
    if (options.areaId == undefined) {
      return;
    }
    wx.request({
      url: 'http://www.wpd.com/darren/getAreaById',
      data: {
        'areaId': options.areaId
      },
      method: 'GET',
      success: function(res) {
        var area = res.data.area;
        if (area == undefined) {
          var toastText = "获取数据失败" + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            areaName: area.areaName,
            priority: area.priority
          });
        }
      }
    })

  },
  formSubmit: function(req) {
    var that = this;
    var formData = req.detail.value;
    var url = this.data.addUrl;
    if (this.data.areaId != undefined) {
      formData.areaId = this.data.areaId;
      url = this.data.updateUrl;
    }
    wx.request({
      url: url,
      data: JSON.stringify(formData),
      method: 'POST',
      header: {
        'Content-Type': 'application/json'
      },
      success: function(resp) {
        var result = resp.data.status;
        var toastText = '操作成功！';
        if (result == "FAIL") {
          toastText = '操作失败！' + res.data.errMsg;
        }
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });
        wx.redirectTo({
          url: '../list/areaList'
        });
        if (that.data.areaId != undefined) {
          
        }

      }


    })



  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})