function main(){
    let F_C = new Circle(500,500,80);
    F_C.createMultipleCircle();
}
main();
class Circle {
    constructor(x, y, radius, color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    render(canvas) {
        const ctx = canvas.getContext("2d");
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
        ctx.fillStyle = this.color;
        ctx.fill();
    }
}

// Example usage:
const canvas = document.getElementById("myCanvas"); // Replace "myCanvas" with your canvas ID
const myCircle = new Circle(50, 50, 80, "#000000");
myCircle.render(canvas);

