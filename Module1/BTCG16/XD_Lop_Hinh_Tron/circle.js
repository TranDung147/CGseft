let Circle = function (radius) {
    this.radius = radius;
    this.getRadius = function (){
        return radius;
    }
    this.getArea = function (){
        return Math.PI * radius * radius;
    }
};
let circleObject1 = new Circle(2);
let radius = circleObject1.getRadius();
let area = circleObject1.getArea();
alert("Radius = " + radius + "; Area = " + area);
let circleObject2 = new Circle(4);
radius = circleObject2.getRadius();
area = circleObject2.getArea();
alert("Radius = " + radius + "; Area = " + area);
