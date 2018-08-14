// pages/swiper/swiper.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls: [
      '/static/images/swiper_01.jpg',
      '/static/images/swiper_04.jpg',
      '/static/images/swiper_03.jpg'
    ],
    indicatorDots: false,
    autoplay: false,
    interval: 5000,
    duration: 1000,
    prodList: [{
        logo: '/static/images/cake.jpg',
        title: '糕点制作',
        desc: '关键词：蛋糕 甜点 美食 下午茶 水果 慕斯 餐饮美食 西餐美食'
      },
      {
        logo: '/static/images/bottle_wine.jpg',
        title: '鸡尾酒调制',
        desc: '关键词：鸡尾酒 预调酒 饮料 冷饮 柠檬 果汁'
      }
    ]
  },
  toDetail: function(e) {
    console.log(e);
    var index=e.currentTarget.dataset.index;
    console.log(index);
    if(index==1) {
      wx.navigateTo({
        url: '../join/join',
      });
    }
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