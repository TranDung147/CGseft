let c = document.getElementById("myCanvas");
let ctx = c.getContext("2d");
//-----------In chữ-----------
//ctx.font = "30px Arial";
//ctx.strokeText("Hello World",10,50);
//ctx.font = "30px Arial";
//ctx.fillText("Hello World",10,50);
//-----------In đường kẻ-----------
/*ctx.moveTo(0,0);
ctx.lineTo(200,100);
ctx.stroke();*/
//-----------In hình tròn-----------
/*ctx.beginPath();
ctx.arc(95,50,40,0,2*Math.PI);
ctx.stroke();*/
//-----------In ảnh mờ-----------
// Create gradient
/*var grd = ctx.createLinearGradient(0,0,200,0);
grd.addColorStop(0,"red");
grd.addColorStop(1,"white");

// Fill with gradient
ctx.fillStyle = grd;
ctx.fillRect(10,10,150,80);*/
//-----------In ảnh mờ có hình tròn giữa-----------
var grd = ctx.createRadialGradient(75,50,5,90,60,100);
grd.addColorStop(0,"red");
grd.addColorStop(1,"white");

// Fill with gradient
ctx.fillStyle = grd;
ctx.fillRect(10,10,150,80);