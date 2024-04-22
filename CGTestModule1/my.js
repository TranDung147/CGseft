function findAvg(arr) {
    if (arr.length === 0) {
        return 0;
    }
    let avg = 0;
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
        sum = sum + arr[i];
    }
    return avg = sum / arr.length;
}

function insertNumberToArray(arr, x, index) {
    if (index < 0 || index > arr.length) {
        return arr;
    }

    let newArray = [...arr];
    newArray.splice(index, 0, x);

    return newArray;
}

function isPrime(num) {
    if (num <= 1) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}

function sumOfListPrime(x) {
    let sum = 0;
    for (let i = 0; i <= x; i++) {
        if (isPrime(i)) {
            sum += i;
        }
    }
    return sum;
}

class Circle {
    constructor(x, y, radius, color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    render(canvas) {
        let ctx = canvas.getContext("2d");
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
        ctx.fillStyle = this.color;
        ctx.fill();
    }
}

let canvas = document.getElementById("myCanvas");
let newCircle = new Circle(50, 50, 80, "#000000");
newCircle.render(canvas);

let c = document.getElementById("myCanvas");
let ctx = c.getContext("2d");
ctx.beginPath();
ctx.arc(50, 50, 80, 0, 2 * Math.PI);
