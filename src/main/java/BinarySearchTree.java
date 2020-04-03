import java.util.List;

public class BinarySearchTree {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
            if (tree.left != null) {
                inOrderTraverse(tree.left, array);
            }

            array.add(tree.value);

            if (tree.right != null) {
                inOrderTraverse(tree.right, array);
            }

            return array;
        }

        public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
            array.add(tree.value);
            if (tree.left != null) {
                inOrderTraverse(tree.left, array);
            }
            if (tree.right != null) {
                inOrderTraverse(tree.right, array);
            }

            return array;
        }

        public static boolean validateBst(BST tree) {

            return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public static boolean validateBst(BST tree, int minValue, int maxValue) {
            if (tree.value > maxValue || tree.value < minValue) {
                return false;
            }
            if (tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
                return false;
            }
            if (tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
                return false;
            }
            return true;
        }

        public BST insert(int value) {
            if(value < this.value){
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if (this.value == value) {
                return true;
            }
            if(value < this.value){
                if (this.left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if (this.right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            if (value < this.value) {
                if (this.left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (this.right != null) {
                    right.remove(value, this);
                }
            } else {

                if (this.left != null && this.right != null) {
                    this.value = right.findMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {

                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        value = 0;
                    }

                } else if(parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if(parent.right == this) {
                    parent.right = left != null ? left : right;
                }

            }
        }

        public int findMinValue() {
            if (left != null) {
                return left.findMinValue();
            } else {
                return value;
            }
        }


//        public void tset() {
//            if (value < this.value) {
//                if (this.left != null) {
//                    left.remove(value, this);
//                }
//            } else if (value > this.value) {
//                if (this.right != null) {
//                    right.remove(value, this);
//                }
//            } else {
//
//                if (this.left != null && this.right != null) {
//                    this.value = right.findMinValue();
//                    right.remove(this.value, this);
//                } else if (parent == null) {
//
//                    if (left != null) {
//                        this.value = left.value;
//                        right = left.right;
//                        left = left.left;
//                    } else if (right != null) {
//                        this.value = right.value;
//                        left = right.left;
//                        right = right.right;
//                    } else {
//                        value = 0;
//                    }
//
//                } else if(parent.left == this) {
//                    parent.left = left != null ? left : right;
//                } else if(parent.right == this) {
//                    parent.right = left != null ? left : right;
//                }
//
//            }
//        }
    }
}
