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