package by.gosha_krovsh.threadShop;


public final class Shelf {
    static Good Vodka = new Good(1, "Vodka", 5.50, 0);
    static Good Beer = new Good(2, "Beer", 2.30, 5);
    static Good Crisps = new Good(3, "Crisps", 1.90, 0);
    static Good Bread = new Good(4, "Bread", 0.99, 0);
    static Good Milk = new Good(5, "Milk", 0.99, 0);
    static Good Herring = new Good(6, "Herring", 2.10, 6);
    static Good Kefir = new Good(7, "Kefir", 1, 0);
    static Good WhiteBread = new Good(8, "WhiteBread", 1.30, 15);
    static Good Baton = new Good(9, "Baton", 0.99, 0);
    static Good BuckWheat = new Good(10, "BuckWheat", 0.60, 0);
    static Good Sausage = new Good(11, "Sausage", 1.80, 10);
    static Good Yoghurt = new Good(12, "Yoghurt", 0.90, 89);
    static Good Bun = new Good(13, "Bun", 0.80, 0);

    protected static Good getRandomGood() {
        int random = (int) (Math.random() * 12 + 1);
        switch (random) {
            case 1:
                return Vodka;
            case 2:
                return Beer;
            case 3:
                return Crisps;
            case 4:
                return Bread;
            case 5:
                return Milk;
            case 6:
                return Herring;
            case 7:
                return Kefir;
            case 8:
                return WhiteBread;
            case 9:
                return Baton;
            case 10:
                return BuckWheat;
            case 11:
                return Sausage;
            case 12:
                return Yoghurt;
            case 13:
                return Bun;
            default:
                return Bun;
        }

    }

}
