// pages/list/areaList.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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
    var that = this;
    wx.request({
      url: 'http://pay.bilibili.co/userAuth/darren/areaList',
      method: 'GET',
      data: {},
      success: function(res) {
        var list = res.data.areasList;
        if (null == list) {
          var toastTitle = '获取列表失败' + res.data.errMsg;
          wx.showToast({
            title: toastTitle,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({ // 调用方已发生变化
            list: list
          });
        }
      }
    });

  },
  addArea: function () {
    wx.navigateTo({
      url: '../operation/operation',
    })
  },

  deleteArea: function (req) {
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确认删除[' + req.target.dataset.areaname + ']吗？',
      success: function (sm) {
        if (sm.confirm) {
          wx.request({
            url: 'http://pay.bilibili.com/userAuth/darren/deleteArea',
            method: 'GET',
            data: {
              'areaId': req.target.dataset.areaid
            },
            success: function (result) {
              var status = result.data.status;
              var toastText = "删除成功！";
              if (status == 'FAIL') {
                toastText = "删除失败！";
              } else {
                that.data.list.splice(req.target.dataset.index, 1)
                that.setData({
                  list: that.data.list
                });
              }
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 1000
              });
            }
          });
        }
      }
    });
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