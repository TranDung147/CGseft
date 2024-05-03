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