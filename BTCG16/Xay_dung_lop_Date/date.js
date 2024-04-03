let myDate = function (day, month, year){
    this.day = day;
    this.month = month;
    this.year = year;
    this.getDay = function (){
        return this.day;
    }
    this.getMonth = function (){
        return this.month;
    }
    this.getYear = function (){
        return this.year;
    }
    this.setDay = function (day){
        this.day = day;
    }
    this.setMonth = function (month){
        this.month = month;
    }
    this.setYear = function (year){
        this.year = year;
    }
    this.setDate = function (date) {
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
    }
    this.toString = function () {
        return this.day + "/" + this.month + "/" + this.year;
    }
};
let date = new myDate(2,2,2007);
date.setDate(new myDate(10,9,2019));
alert(date.toString());



