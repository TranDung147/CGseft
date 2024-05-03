function insertNumberToArray(arr, x, index) {
    if (index < 0 || index > arr.length) {
        return arr;
    }

    let newArray = [...arr];
    newArray.splice(index, 0, x);

    return newArray;
}