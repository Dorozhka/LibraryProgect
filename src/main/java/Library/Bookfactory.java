package Library;

import manager.ExcelProvider;

public interface Bookfactory {
    Book createTextbook();

    /**
     *
     * @param numCol
     * @return
     */
    Book createFiction(int numCol);
    static ExcelProvider excelprovider = new ExcelProvider("C:/Users/Dasha/OneDrive/Рабочий стол/Учёба/Институт/Дурацкие лабы/Java_6sem_lab1/Книги.xlsx");
}
