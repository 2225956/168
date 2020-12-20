/**
 * 点击图片，从后端获取新生成的验证码
 */
function changeImg(){
	document.getElementById("vcodeImg").src = "createVerifyImage.do?t = "+ Math.random();
}