class User{
    name;
    age;
    email;
    constructor(name, age, email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    checkAge(){
        if (this.age < 18){
            alert(this.name + " khong du tuoi");
        } else
            alert(this.name + " da du tuoi truong thanh");
    }
}