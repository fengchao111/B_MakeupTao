webpackJsonp([11],{"1nBx":function(t,s,r){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var e=r("pFYg"),i=r.n(e),a=r("f0X5"),d={name:"ordergetdetail",data:function(){return{day:"9",hour:"23",msg:"订单详情",paylists:[]}},methods:{jumpzmy:function(){this.$router.push({path:"/details?user_id="+this.$route.query.user_id})},waitget:function(){this.$router.push({path:"/get?user_id="+this.$route.query.user_id})}},mounted:function(){var t=this;a.a.$on("orderpay",function(s){console.log(i()(JSON.parse(s))),t.paylists=JSON.parse(s)})}},_={render:function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{attrs:{id:"ordergetdetail"}},[e("div",{attrs:{id:"detailbanner"}},[e("img",{attrs:{id:"left",src:r("OE74")},on:{click:function(s){t.waitget()}}}),t._v(" "),e("p",[t._v(t._s(t.msg))]),t._v(" "),e("input",{attrs:{id:"order_more",type:"button",value:"●●●"}})]),t._v(" "),e("div",{attrs:{id:"order_status"}},[e("img",{attrs:{src:r("7730")}}),t._v(" "),e("p",[t._v("卖家已发货")]),t._v(" "),e("p",[t._v("剩"+t._s(t.day)+"天"+t._s(t.hour)+"小时自动确认")])]),t._v(" "),e("div",{attrs:{id:"address"}},[e("img",{attrs:{src:r("/cD8"),id:"address_picture"}}),t._v(" "),e("div",{staticClass:"right"},[e("p",[e("span",[t._v("收货人："+t._s(t.paylists[0].address.address_name))]),t._v(" "),e("span",[t._v(t._s(t.paylists[0].address.address_tel))])]),t._v(" "),e("p",[t._v("收货地址："+t._s(t.paylists[0].address.address_add))])])]),t._v(" "),e("div",{staticClass:"orderdetailbox"},[t._m(0),t._v(" "),t._l(t.paylists[0].pro_shops,function(s){return e("div",{key:s.pro_shop_id,staticClass:"boxdetail"},[e("div",{staticClass:"imgboxdetail clearfix",on:{click:function(s){t.jumpzmy()}}},[e("img",{attrs:{src:s.pro_shop_pic}}),t._v(" "),e("p",{attrs:{id:"decrisptdetail"}},[t._v(t._s(s.pro_shop_orders.pro_shop_desc))]),t._v(" "),e("div",{attrs:{id:"pricedetail"}},[e("span",[t._v("￥"+t._s(s.pro_shop_orders.pro_shop_order_price))]),t._v(" "),e("span",[t._v("￥"+t._s(s.pro_shop_orders.pro_shop_order_oldprice))]),t._v(" "),e("span",[t._v("x"+t._s(s.pro_shop_orders.pro_shop_order_number))])])])])})],2),t._v(" "),t._m(1),t._v(" "),e("p",{staticClass:"enddetial"},[e("span",[t._v("实付款（含运费）")]),t._v(" "),e("span",{attrs:{id:"enddetail"}},[t._v(t._s(t.paylists[0].order_money))])]),t._v(" "),e("div",{attrs:{id:"mess"}},[e("span",[t._v("买家留言：")]),t._v(" "),e("div",{attrs:{id:"intext"}},[t._v(t._s(t.paylists[0].order_message))])]),t._v(" "),e("div",{attrs:{id:"tryend"}},[e("p",{attrs:{id:"codedetail"}},[t._v("订单编号： "+t._s(t.paylists[0].order_id))]),t._v(" "),e("p",{attrs:{id:"builddetail"}},[t._v("创建时间： "+t._s(t.paylists[0].order_time))])]),t._v(" "),e("div",{attrs:{id:"footer"}},[e("input",{attrs:{type:"button",value:"延长收货"},on:{click:function(s){t.del1(t.payorder)}}}),t._v(" "),e("input",{attrs:{type:"button",value:"确认收货"},on:{click:function(s){t.del2(t.payorder)}}})])])},staticRenderFns:[function(){var t=this,s=t.$createElement,r=t._self._c||s;return r("p",{staticClass:"shops"},[r("span",[t._v("美妆品牌店 ＞")])])},function(){var t=this,s=t.$createElement,r=t._self._c||s;return r("p",{staticClass:"enddetial"},[r("span",[t._v("运费")]),t._v(" "),r("span",{attrs:{id:"sendprice"}},[t._v("￥8.05")])])}]};var o=r("VU/8")(d,_,!1,function(t){r("Qmpz")},"data-v-d6c3ac72",null);s.default=o.exports},7730:function(t,s,r){t.exports=r.p+"static/img/待收货.46ad7b3.png"},Qmpz:function(t,s){}});
//# sourceMappingURL=11.98961f4a7bb52fb5f08d.js.map