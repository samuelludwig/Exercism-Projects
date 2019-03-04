class Gigasecond {
    init_date: Date;
    constructor(time: Date) {
        this.init_date = time;
    }

    date() {
        let gigsec = 1000000000*1000;
        return new Date(this.init_date.getTime() + gigsec); 
    }
}

export default Gigasecond;