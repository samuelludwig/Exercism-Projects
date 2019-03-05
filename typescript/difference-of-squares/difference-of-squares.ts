class Squares {
    num: number;
    sumOfSquares: number;
    squareOfSum: number;
    difference: number;

    constructor(n: number) {
        this.num = n;
        
        this.sumOfSquares = ((x) => {
            let sum = 0;
            for (let i = 1; i <= x; i++) {
                sum += (i * i);              
            }
            return sum;
        })(this.num);
    
        this.squareOfSum = ((x) => {
            let sum = 0;
            for (let i = 1; i <= x; i++) {
                sum += i;              
            }
            return (sum * sum);
        })(this.num);
    
        this.difference = (this.squareOfSum - this.sumOfSquares);
    }
}

export default Squares