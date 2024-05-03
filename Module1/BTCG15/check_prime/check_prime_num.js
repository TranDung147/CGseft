let number = parseInt(prompt("Nhập vào số cần kiểm tra: "));
isPrime(number);
function isPrime(number){
        if (number <= 1) {
            alert(number + " không là số nguyên tố");
            return;
        }
        let check = true;
            for (let i = 2; i <= Math.sqrt(number) ; i++) {
                if (number % i === 0) {
                    check = false;
                    break;
                }
            }
        if (check){
            alert(number + " là số nguyên tố");
        } else {
            alert(number + " không là số nguyên tố");
    }
}