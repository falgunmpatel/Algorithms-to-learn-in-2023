function beadSort(a, len) {
    // Find the maximum element
    let max = a[0];
    for (let i = 1; i < len; i++) {
        if (a[i] > max) {
            max = a[i];
        }
    }

    // allocating memory
    const beads = new Array(len).fill().map(() => new Array(max).fill(0));

    // mark the beads
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < a[i]; j++) {
            beads[i][j] = 1;
        }
    }

    // move down the beads
    for (let j = 0; j < max; j++) {
        let sum = 0;
        for (let i = 0; i < len; i++) {
            sum += beads[i][j];
            beads[i][j] = 0;
        }
        for (let i = len-1; i >= len-sum; i--) {
            beads[i][j] = 1;
        }
    }

    // to get sorted array
    const result = new Array(len);
    for (let i = 0; i < len; i++) {
        let sum = 0;
        for (let j = 0; j < max; j++) {
            sum += beads[i][j];
        }
        result[i] = sum;
    }
    return result;
}

const result = beadSort([3, 1, 4, 1, 5], 5);
console.log(result);