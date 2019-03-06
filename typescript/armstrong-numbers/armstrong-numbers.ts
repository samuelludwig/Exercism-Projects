class ArmstrongNumbers {
    static isArmstrongNumber(num: number) {
        let armnum = ((x) => {
            let xarr = Array.from(x.toString());
            let sum = 0;
            for (let pos = 1; pos <= xarr.length; pos++) {
                sum += (parseInt(xarr[pos-1]) ** (xarr.length));
            }
            return sum;
        })(num);

        return (num == armnum);
    }
}

export default ArmstrongNumbers;