public class Rabbit {
    public static void main(String[] args) {
        int[] carrotPatches = {1, 2, 3, 4, 5}; // Масса моркови на каждой полянке
        int maxCarry = 5; // Максимальная масса моркови, которую может взять заяц
        int moves = 10; // Количество ходов
        int totalCarrots = 0; // Общее количество собранной моркови

        for (int i = 0; i < moves; i++) {
            int maxPatchIndex = findMaxPatch(carrotPatches, maxCarry);
            if (maxPatchIndex != -1) { // Проверяем, есть ли ещё морковь для сбора
                totalCarrots += carrotPatches[maxPatchIndex];
                carrotPatches[maxPatchIndex] = 0; // Заяц забирает всю морковь с полянки
            }
        }

        System.out.println("Максимальное количество моркови, которое заяц может унести за 10 ходов: " + totalCarrots);
    }

    // Функция для нахождения полянки с максимальным количеством моркови, которое заяц может взять
    public static int findMaxPatch(int[] patches, int maxCarry) {
        int maxIndex = -1;
        int maxValue = 0;

        for (int i = 0; i < patches.length; i++) {
            if (patches[i] > maxValue && patches[i] <= maxCarry) {
                maxValue = patches[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
