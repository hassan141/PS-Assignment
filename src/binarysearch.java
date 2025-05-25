class binarySearch {

    public static int BinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target1 = 23;
        int target2 = 42;

        int index1 = BinarySearch(sortedArray, target1);
        int index2 = BinarySearch(sortedArray, target2);


        System.out.println("Index of " + target1 + ": " + index1);
        System.out.println("Index of " + target2 + ": " + index2);
    }

}