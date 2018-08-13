// pages/join/join.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    introduce: [{
      title: ' 制作材料',
      desc: '鸡尾酒 预调酒 饮料 冷饮 柠檬 果汁'
      },
      {
        title: '背景介绍',
        desc: '鸡尾酒，是想象力的杰作。鸡尾酒的本性，已经决定了它必将是一种最受不得任何约束与桎梏的创造性事物。至于在未来的日子里究竟还有多少种鸡尾酒将会被研制出来，这个问题似乎也只是和人类自身的想象力有关。对照起永远缺乏变化的现实生活来说，这样的一种美就自然也就显得更加弥足珍贵了。'
      },
      {
        title: '调制方法',
        desc: '取一个鸡尾酒碟，将杯子置于冰箱内冰冻后取出，倒扣于盐上旋转几次，使其沿口沾上一层“盐霜”，将3种配料加冰块后倒入摇杯内摇匀，倒入鸡尾酒碟后上桌。（注：许多人会把这款酒的盐边用柠檬抹一圈湿边后去沾盐，这样是错误的。）'
      }
    ]
  },
  call: function() {
    wx.makePhoneCall({
      phoneNumber: '13255554313' //仅为示例，并非真实的电话号码
    })
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