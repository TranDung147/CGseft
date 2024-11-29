class Circle {
    x;
    y;
    radius;
    color;

    constructor(x, y, radius, color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.canvas = document.getElementById("myCanvas");
        this.ctx = canvas.getContext("2d");
        this.flag = "up";
    }

    draw() {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2);
        ctx.fillStyle = this.color;
        ctx.fill();
    }
    moveTop(){
        this.y -= 2;
        //this.x += 2;
    }

    moveDown(){
        this.y += 2;
        //this.x -= 2;
    }
    move(){
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
        if (this.y - this.radius <= 0) {
            this.flag = "down";
        } else if (this.y + this.radius >= this.canvas.height){
            this.flag = "up";
        }

        switch (this.flag){
            case "down":
                this.moveDown();
                break;
            default:
                this.moveTop();
        }
        this.draw();
    }
}