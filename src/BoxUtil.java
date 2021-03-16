public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        dest.put(src.get());
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        if (src.get() != null && src.get().isFresh()) {
            dest.put(src.get());
        }
    }

    //вывести в консоль (toString()) объект второй коробки
    public static void printElementFromTwoBoxes(final Box<Box> box) {
        if (box.get() != null && box.get().get() != null) {
            System.out.println(box.get().get().toString());
        } else {
            System.out.println((String) null);
        }
    }

    // вывести в консоль (toString()) объект последней коробки box Box,
    // которая содержит в себе любое кол-во вложенных Box, в последней из которых может быть любой объект.
    public static <T> void printElementFromBoxes(final Box<T> box) {
        if (box.get() instanceof Box) {
            printElementFromBoxes((Box<T>) box.get());
        } else {
            if (box.get() != null) {
                System.out.println(box.get().toString());
            } else {
                System.out.println((String) null);
            }
    }
    }
}

