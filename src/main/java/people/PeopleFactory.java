
package people;

import manager.ExcelProvider;

public abstract class PeopleFactory {
    static ExcelProvider excelprovider = new ExcelProvider("C:/Users/Dasha/OneDrive/Рабочий стол/Учёба/Институт/Дурацкие лабы/Java_6sem_lab1/Имена.xlsx");

    /**
     *
     * @return
     */
    public abstract boolean sexGetting();

    /**
     *
     * @param sex
     * @return
     */
    public abstract People createPerson(boolean sex);
    
}
