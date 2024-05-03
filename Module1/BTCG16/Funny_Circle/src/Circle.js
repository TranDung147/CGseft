class Circle {
    constructor(x,y,radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    createCircle(){
        let ctx = document.getElementById("myCanvas").getContext("2d");
        this.radius = Math.floor(Math.random() * 80);
        let color = this.getRanDomColor();
        this.x = Math.random() * window.innerWidth;
        this.y = Math.random() * window.innerHeight;
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
        ctx.fillStyle = color;
        ctx.fill();
    }
    getRandomHex(){
        return Math.floor(Math.random() * 255);
    }
    getRanDomColor(){
        let red = this.getRandomHex();
        let green = this.getRandomHex();
        let blue = this.getRandomHex();
            return "rgb(" + red + "," + green + "," + blue + ")";
    }
    createMultipleCircle(){
        for (let i = 0; i < 30; i++) {
            this.createCircle()
        }
    }
}

