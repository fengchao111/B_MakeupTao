webpackJsonp([22],{N5Eb:function(t,n){},Oz99:function(t,n,a){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var e=a("4kSj"),r=a.n(e),s={name:"changepw",data:function(){return{msg:""}},methods:{changepwData:function(){this.$router.push({path:"/manage?user_id="+this.$route.query.user_id})},pw1:function(){return!!/^[a-zA-Z0-9]{6,15}$/.test(r()("#pw1").val())||(alert("密码由6-15位数字字母组成"),!1)},pw2:function(){return!!/^[a-zA-Z0-9]{6,15}$/.test(r()("#pw2").val())||(alert("密码由6-15位数字字母组成jbj"),!1)},pw3:function(){return r()("#pw3").val()===r()("#pw2").val()||(alert("两次输入密码不一致"),!1)},pw:function(){if(!(this.$options.methods.pw1()&&this.$options.methods.pw2()&&this.$options.methods.pw3))return alert("请正确输入密码"),!1;r.a.ajax({url:"gaimima.htm?user_id=2&old_password="+r()("#pw1").val()+"&new_password="+r()("#pw2").val(),type:"get",dataType:"json",success:function(t){return t?(alert("修改成功"),!0):(alert("密码错误请重新输入"),!1)}})}}},p={render:function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",{attrs:{id:"changepw"}},[e("p",{attrs:{id:"changepw-data"}},[e("img",{attrs:{id:"changepw-data1",src:a("OE74")},on:{click:function(n){t.changepwData()}}}),t._v("密 码 更 改")]),t._v(" "),e("form",{attrs:{id:"changepw-list"}},[e("div",[e("p",[t._v("原 密 码")]),t._v(" "),e("input",{attrs:{type:"password",id:"pw1"},on:{blur:function(n){t.pw1()}}})]),t._v(" "),e("div",[e("p",[t._v("新 密 码")]),t._v(" "),e("input",{attrs:{type:"password",id:"pw2"},on:{blur:function(n){t.pw2()}}})]),t._v(" "),e("div",[e("p",[t._v("确认密码")]),t._v(" "),e("input",{attrs:{type:"password",id:"pw3"},on:{blur:function(n){t.pw3()}}})]),t._v(" "),e("button",{staticClass:"changepw-sub",on:{click:function(n){t.pw()}}},[t._v("提交")])])])},staticRenderFns:[]};var i=a("VU/8")(s,p,!1,function(t){a("N5Eb")},"data-v-7c757c0d",null);n.default=i.exports}});
//# sourceMappingURL=22.2920561fd62c9283c78f.js.map