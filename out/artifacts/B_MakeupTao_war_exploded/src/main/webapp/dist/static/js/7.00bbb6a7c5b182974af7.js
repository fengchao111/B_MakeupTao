webpackJsonp([7,24],{RjUe:function(e,t){},VMz3:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r("mvHQ"),a=r.n(s),n=r("f0X5"),o={components:{Paypic:r("xIZV").default},name:"orderpay",data:function(){return{index:"",seen:!1,num:"2",shows:!1,att:[],payorders:[],pay_order_id:""}},methods:{see:function(){for(var e=document.getElementsByClassName("selectH"),t=0;t<e.length;t++){if(!0===e[t].checked){this.seen=!0;break}this.seen=!1}},del:function(e,t){if(confirm("确认取消?")){var r={};r[0]=t,this.payorders.splice(e,1);var s=new XMLHttpRequest;s.open("post","cancleOrder.htm",!0),s.setRequestHeader("Content-type","application/x-www-form-urlencoded"),s.send("cancle_order_id="+a()(r)),s.onreadystatechange=function(){4===s.readyState&&200===s.status?alert("一个订单已取消"):console.log("error")}}},pay:function(e,t){if(confirm("确认付款?")){this.shows=!this.shows,this.$nextTick(function(){var e=document.getElementsByClassName("money")[0];console.log(e.innerHTML),n.a.$emit("sendPri",parseFloat(e.innerHTML))});var r={};r[0]=t,this.payorders.splice(e,1);var s=new XMLHttpRequest;s.open("post","sureOrder.htm",!0),s.setRequestHeader("Content-type","application/x-www-form-urlencoded"),s.send("sure_order_id="+a()(r)),s.onreadystatechange=function(){4===s.readyState&&200===s.status?alert("一个订单已确认付款"):console.log("error")}}},adddel:function(){var e=document.getElementsByClassName("selectH"),t=document.getElementsByClassName("orderpaybox");if(confirm("确认取消?")){for(var r={},s=0;s<e.length;s++)!0===e[s].checked&&(t[s].style.display="none",r[s]=this.payorders[s].order_id);var n=new XMLHttpRequest;n.open("post","cancleOrder.htm",!0),n.setRequestHeader("Content-type","application/x-www-form-urlencoded"),n.send("cancle_order_id="+a()(r)),n.onreadystatechange=function(){4===n.readyState&&200===n.status?alert("多个订单已取消"):console.log("error")}}},addpay:function(){var e=document.getElementsByClassName("selectH"),t=document.getElementsByClassName("orderpaybox");if(confirm("确认付款?")){this.shows=!this.shows;for(var r=document.getElementsByClassName("money"),s=0,a=0;a<e.length;a++)!0===e[a].checked&&(t[a].style.display="none",s+=parseFloat(r[a].innerHTML));this.$nextTick(function(){console.log(s),n.a.$emit("sendPri",parseFloat(s))}),this.show=!this.show}},waitpay:function(e){this.$router.push({path:"/paydetail?user_id="+this.$route.query.user_id});var t=new XMLHttpRequest;t.onreadystatechange=function(){4===t.readyState&&200===t.status?n.a.$emit("orderpay",JSON.parse(t.responseText)):console.log("error")},t.open("post","orderDetails.htm",!0),t.setRequestHeader("Content-type","application/x-www-form-urlencoded"),t.send("order_id="+e)},detial:function(e){},price:function(){var e=this,t=new XMLHttpRequest;t.open("post","someOrder.htm",!0),t.setRequestHeader("Content-type","application/x-www-form-urlencoded"),t.send("user_id=1&user_sex=1"),t.onreadystatechange=function(){4===t.readyState&&200===t.status?e.payorders=JSON.parse(JSON.parse(t.responseText)):console.log("error")}}},mounted:function(){this.price()}},i={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"orderpay"}},[e._l(e.payorders,function(t,s){return r("div",{key:t.order_id,staticClass:"orderpaybox"},[r("p",{staticClass:"shoppay"},[r("span",[r("input",{staticClass:"selectH",attrs:{type:"checkbox"},on:{click:function(t){e.see()}}}),e._v(" 美妆品牌店 ＞")]),r("span",[e._v("等待买家付款")])]),e._v(" "),e._l(t.pro_shops,function(s){return r("div",{key:s.pro_shop_orders.pro_shop_order_id,staticClass:"boxpay"},[r("div",{staticClass:"imgboxpay clearfix",on:{click:function(r){e.waitpay(t.order_id)}}},[r("img",{attrs:{src:s.pro_shop_pic}}),e._v(" "),r("p",{attrs:{id:"decrisptpay"}},[e._v(e._s(s.pro_shop_desc))]),e._v(" "),r("div",{attrs:{id:"pricepay"}},[r("span",[e._v("￥"+e._s(s.pro_shop_orders.pro_shop_order_price))]),e._v(" "),r("span",[e._v("￥"+e._s(s.pro_shop_orders.pro_shop_order_oldprice))]),e._v(" "),r("span",[e._v("x"+e._s(s.pro_shop_orders.pro_shop_order_number))])])])])}),e._v(" "),r("div",{attrs:{id:"okendpay"}},[r("p",{attrs:{id:"resultendpay"}},[r("span",[e._v("共"+e._s(e.num)+"件商品")]),e._v(" "),r("span",[e._v("合计：￥"),r("span",{staticClass:"money"},[e._v(e._s(t.order_money))]),e._v("(含运费 ￥"+e._s(0)+")")])]),e._v(" "),r("p",{attrs:{id:"focendpay"}},[r("input",{attrs:{type:"button",value:"联系卖家"}}),e._v(" "),r("input",{attrs:{type:"button",value:"取消订单"},on:{click:function(r){e.del(s,t.order_id)}}}),e._v(" "),r("input",{attrs:{type:"button",value:"付款"},on:{click:function(r){e.pay(s,t.order_id)}}})])])],2)}),e._v(" "),e.seen?r("div",{attrs:{id:"footer"}},[r("input",{attrs:{type:"button",value:"取消订单"},on:{click:function(t){e.adddel()}}}),e._v(" "),r("input",{attrs:{type:"button",value:"合并付款"},on:{click:function(t){e.addpay()}}})]):e._e(),e._v(" "),e.shows?r("paypic"):e._e()],2)},staticRenderFns:[]};var d=r("VU/8")(o,i,!1,function(e){r("i8n9")},"data-v-4702308c",null);t.default=d.exports},g7mL:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=r("i295"),a=r("VMz3"),n={name:"pays",data:function(){return{}},components:{orderbanner:s.default,orderpay:a.default},methods:{waitpay:function(e,t){switch(e){case"msg":this.$router.push({path:"/allmsg?user_id="+this.$route.query.user_id});break;case"get":this.$router.push({path:"/allget?user_id="+this.$route.query.user_id});break;case"pay":this.$router.push({path:"/allpay?user_id="+this.$route.query.user_id});break;case"end":this.$router.push({path:"/allend?user_id="+this.$route.query.user_id});break;case"all":this.$router.push({path:"/allall?user_id="+this.$route.query.user_id})}}}},o={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"pay"}},[r("orderbanner"),e._v(" "),r("div",{attrs:{id:"ordernav"}},[r("div",{attrs:{id:"ordernav1"}},[r("ul",{attrs:{id:"nav1"}},[r("li",[r("a",{on:{click:function(t){e.waitpay("all",0)}}},[e._v("全部")])]),e._v(" "),r("li",[r("a",{on:{click:function(t){e.waitpay("pay",1)}}},[e._v("待付款")])]),e._v(" "),r("li",[r("a",{on:{click:function(t){e.waitpay("get",2)}}},[e._v("待收货")])]),e._v(" "),r("li",[r("a",{on:{click:function(t){e.waitpay("msg",3)}}},[e._v("待评价")])]),e._v(" "),r("li",[r("a",{on:{click:function(t){e.waitpay("end",4)}}},[e._v("已完成")])])])])]),e._v(" "),r("orderpay")],1)},staticRenderFns:[]};var i=r("VU/8")(n,o,!1,function(e){r("RjUe")},"data-v-ab746a58",null);t.default=i.exports},i8n9:function(e,t){}});
//# sourceMappingURL=7.00bbb6a7c5b182974af7.js.map