let board;
let score = 0;
let rows = 4;
let columns = 4;

window.onload = function () {
    setGame();
}

function setGame() {
    board = [
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0]
    ]
    // board = [
    //     [2, 2, 2, 2],
    //     [2, 2, 2, 2],
    //     [4, 4, 8, 8],
    //     [4, 4, 8, 8]
    // ]

    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            let tile = document.createElement("div");
            tile.id = i.toString() + "-" + j.toString();
            let num = board[i][j];
            updateTile(tile, num);
            document.getElementById("myBoard").append(tile);
        }
    }
    setTwo();
    setTwo();
}

function hasEmptyTile() {
    for (let j = 0; j < rows; j++) {
        for (let i = 0; i < columns; i++) {
            if (board[j][i] == 0) {
                return true;
            }
        }
    }
    return false;
}

function setTwo() {
    if (!hasEmptyTile()) {
        return;
    }
    let found = false;
    while (!found) {
        //random j,i
        let j = Math.floor(Math.random() * rows);
        let i = Math.floor(Math.random() * columns);

        if (board[j][i] == 0) {
            board[j][i] = 2;
            let tile = document.getElementById(j.toString() + "-" + i.toString());
            tile.innerText = "2";
            tile.classList.add("x2");
            found = true;
        }
    }
}

function updateTile(tile, num) {
    tile.innerText = "";
    tile.classList.value = "";
    tile.classList.add("tile");
    if (num > 0) {
        tile.innerText = num;
        if (num <= 4096) {
            tile.classList.add("x" + num.toString());
        } else {
            tile.classList.add("x8192");
        }
    }
}

document.addEventListener("keyup", (e) => {
    if (e.code == "ArrowLeft") {
        slideLeft();
        setTwo();
    } else if (e.code == "ArrowRight") {
        slideRight();
        setTwo();
    } else if (e.code == "ArrowUp") {
        slideUp();
        setTwo();
    } else if (e.code == "ArrowDown") {
        slideDown();
        setTwo();
    }

    if (isGameLost()) {
        document.getElementById("game-over").innerText = "Game Over!";
    }

    document.getElementById("score").innerText = score;
})

function filterZero(row) {
    return row.filter(num => num != 0);
}

function slide(row) {
    row = filterZero(row);
    for (let i = 0; i < row.length - 1; i++) {
        if (row[i] == row[i + 1]) {
            row[i] *= 2;
            row[i + 1] = 0;
            score += row[i];
        }
    }
    row = filterZero(row);
    while (row.length < columns) {
        row.push(0);
    }
    return row;
}

function slideLeft() {
    for (let i = 0; i < rows; i++) {
        let row = board[i];
        row = slide(row);
        board[i] = row;

        for (let j = 0; j < columns; j++) {
            let tile = document.getElementById(i.toString() + "-" + j.toString());
            let num = board[i][j];
            updateTile(tile, num);
        }
    }
}

function slideRight() {
    for (let i = 0; i < rows; i++) {
        let row = board[i];
        row.reverse();
        row = slide(row);
        row.reverse();
        board[i] = row;

        for (let j = 0; j < columns; j++) {
            let tile = document.getElementById(i.toString() + "-" + j.toString());
            let num = board[i][j];
            updateTile(tile, num);
        }
    }
}

function slideUp() {
    for (let i = 0; i < columns; i++) {
        let row = [board[0][i], board[1][i], board[2][i], board[3][i]];
        row = slide(row);

        for (let j = 0; j < rows; j++) {
            board[j][i] = row[j];
            let tile = document.getElementById(j.toString() + "-" + i.toString());
            let num = board[j][i];
            updateTile(tile, num);
        }
    }
}

function slideDown() {
    for (let i = 0; i < columns; i++) {
        let row = [board[0][i], board[1][i], board[2][i], board[3][i]];
        row.reverse();
        row = slide(row);
        row.reverse();
        for (let j = 0; j < rows; j++) {
            board[j][i] = row[j];
            let tile = document.getElementById(j.toString() + "-" + i.toString());
            let num = board[j][i];
            updateTile(tile, num);
        }
    }
}

function isGameLost() {

    if (hasEmptyTile()) {
        return false;
    }

    for (let j = 0; j < rows; j++) {
        for (let i = 0; i < columns; i++) {
            let current = board[j][i];
            let top = (j > 0) ? board[j - 1][i] : null;
            let right = (i < columns - 1) ? board[j][i + 1] : null;
            let bottom = (j < rows - 1) ? board[j + 1][i] : null;
            let left = (i > 0) ? board[j][i - 1] : null;

            if (current === 0 && (top || right || bottom || left)) {
                return false;
            }

            if (current === board[j][i] && (top === current || right === current || bottom === current || left === current)) {
                return false;
            }
        }
    }

    return true;
}