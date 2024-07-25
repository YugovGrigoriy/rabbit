import java.util.Arrays;
import java.util.PriorityQueue;

/*
Вариант 2
 */
class Field1 {
    int weight;
    int quantity;

    Field1(int weight, int quantity) {
        this.weight = weight;
        this.quantity = quantity;
    }
}

public class RabbitCarrot1 {
    public static void main(String[] args) {

        Field1[] fields = {
                new Field1(1, 10),
                new Field1(2, 5),
                new Field1(3, 6),
                new Field1(4, 3),
                new Field1(5, 2)
        };


        PriorityQueue<Field1> queue = new PriorityQueue<>((f1, f2) -> Integer.compare(f2.weight, f1.weight));


        queue.addAll(Arrays.asList(fields));

        int totalCarrots = 0;
        int trips = 0;

        while (trips < 10 && !queue.isEmpty()) {
            Field1 field = queue.poll();
            int carry = Math.min(5 / field.weight, field.quantity);

            if (carry > 0) {
                totalCarrots += carry * field.weight;
                field.quantity -= carry;
                trips++;


                if (field.quantity > 0) {
                    queue.add(field);
                }
            }
        }

        System.out.println("Заяц унесет всего: " + totalCarrots + " кг моркови за 10 ходок.");
    }
}
