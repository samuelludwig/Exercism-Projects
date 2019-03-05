class Words {
    count(str: String) {
        let word_map = new Map();
        let word_array = str.trim().toLowerCase().split(/[\s]+/);
        word_array.forEach(word => {
            if (word_map.has(word)) {
                word_map.set(word, (word_map.get(word) + 1));
            } else {
                word_map.set(word, 1);
            }
        });
        return word_map;
    }
}

export default Words;