import java.util.Arrays;
import java.util.Comparator;
/*
Вариант 1
 */
class Field {
    int weight;
    int quantity;

    Field(int weight, int quantity) {
        this.weight = weight;
        this.quantity = quantity;
    }
}

public class RabbitCarrot {
    public static void main(String[] args) {

        Field[] fields = {
                new Field(1, 10),
                new Field(2, 5),
                new Field(3, 6),
                new Field(4, 3),
                new Field(5, 2)
        };


        Arrays.sort(fields, Comparator.comparingInt((Field f) -> f.weight).reversed());

        int totalCarrots = 0;
        int trips = 0;

        while (trips < 10) {
            for (Field field : fields) {
                if (trips >= 10) break;

                while (field.quantity > 0 && trips < 10) {
                    int maxCarry = Math.min(5 / field.weight, field.quantity);
                    totalCarrots += maxCarry * field.weight;
                    field.quantity -= maxCarry;
                    trips++;
                }
            }
        }

        System.out.println("Заяц унесет всего: " + totalCarrots + " кг моркови за 10 ходок.");
    }
}