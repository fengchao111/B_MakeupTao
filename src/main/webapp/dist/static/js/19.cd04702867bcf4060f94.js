webpackJsonp([19],{Kbsd:function(n,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=e("4kSj"),u=e.n(a),c={name:"changenum",data:function(){return{num1:"12345678912"}},methods:{changenumData:function(){this.$router.push({path:"/manage?user_id="+this.$route.query.user_id})},changenum1:function(){return!!/^[1][3,4,5,7,8][0-9]{9}$/.test(u()("#phone").val())||(alert("请输入正确手机号"),!1)},changenum2:function(){var n=this.$route.query.user_id;u.a.ajax({url:"gaitel.htm?phone="+u()("#phone").val()+"&user_id="+n,type:"get",dataType:"json",success:function(n){n?alert("修改成功"):alert("修改失败")}})}}},s={render:function(){var n=this,t=n.$createElement,a=n._self._c||t;return a("div",{attrs:{id:"changenum"}},[a("p",{attrs:{id:"changenum-data"}},[a("img",{attrs:{id:"changenum-data1",src:e("OE74")},on:{click:function(t){n.changenumData()}}}),n._v("手机号更改")]),n._v(" "),a("form",{attrs:{id:"changenum-list"}},[a("div",[a("p",{staticClass:"changenum-left"},[n._v("新手机号")]),n._v(" "),a("input",{staticClass:"changenum-input",attrs:{id:"phone",type:"text"},on:{blur:function(t){n.changenum1()}}})]),n._v(" "),a("button",{staticClass:"changenum-sub",on:{click:function(t){n.changenum2()}}},[n._v("提 交")])])])},staticRenderFns:[]};var i=e("VU/8")(c,s,!1,function(n){e("qDjs")},"data-v-b3dcf7aa",null);t.default=i.exports},qDjs:function(n,t){}});
//# sourceMappingURL=19.cd04702867bcf4060f94.js.map