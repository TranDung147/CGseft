function sum(){
    let a = +document.getElementById("a").value;
    let b = +document.getElementById("b").value;
    let x = a + b;
    document.getElementById("result").innerHTML = "Ket qua x = " + x;
}
function sub(){
    let a = +document.getElementById("a").value;
    let b = +document.getElementById("b").value;
    let x = a - b;
    document.getElementById("result").innerHTML = "Ket qua x = " + x;
}
function mul(){
    let a = +document.getElementById("a").value;
    let b = +document.getElementById("b").value;
    let x = a * b;
    document.getElementById("result").innerHTML = "Ket qua x = " + x;
}
function div(){
    let a = +document.getElementById("a").value;
    let b = +document.getElementById("b").value;
    let x = a / b;
    document.getElementById("result").innerHTML = "Ket qua x = " + x;
}