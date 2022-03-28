package array;

import common.Solution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class ValidSudokuSolution extends Solution<Boolean> {

  private static final int BOARD_SIZE = 9;
  private static final int[][] QUADRANT_NUMBER = new int[][] {
      {0, 1, 2},
      {3, 4, 5},
      {6, 7, 8}
  };

  @Getter
  private final char[][] input;

  public ValidSudokuSolution(char[][] input) {
    this.input = input;
  }

  @Override
  protected void initializeSolution() {
    this.title = "Validate Sudoku";
    this.url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/";
    this.notes = "Ad-hoc";
  }

  @Override
  public Boolean solve() {
    return this.validateSize() && this.validateColumns() && this.validateRows()
        && this.validateQuadrants();
  }

  public Boolean solve2() {
    int[] columnBitset = new int[9];
    int[] rowBitset = new int[9];
    int[] quadrantBitset = new int[9];

    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int column = 0; column < BOARD_SIZE; column++) {
        if (this.input[row][column] == '.') {
          continue;
        }

        int value = this.input[row][column] - '0';
        int bitPosition = 1 << value;

        // 0010101001
        // 0000001000 & - Checking if this position was occupied
        // 0000001000

        if ((bitPosition & columnBitset[column]) > 0) {
          return false;
        }

        // 0010101001
        // 0000010000 | - Marking one taken position of bitset
        // 0010111001

        columnBitset[column] |= bitPosition;

        if ((bitPosition & rowBitset[row]) > 0) {
          return false;
        }

        rowBitset[row] |= bitPosition;

        int quadrant = this.getNumberOfQuadrant(row, column);

        if ((bitPosition & quadrantBitset[quadrant]) > 0) {
          return false;
        }

        quadrantBitset[quadrant] |= bitPosition;
      }
    }

    return true;
  }


  private boolean validateSize() {
    boolean result =
        this.input != null && this.input.length == BOARD_SIZE
            && this.input[0].length == BOARD_SIZE;

    return result;
  }

  private boolean validateRows() {
    Map<Character, Boolean> nonRepeatedElementsMap = new HashMap<>();

    for (int i = 0; i < BOARD_SIZE; i++) {
      nonRepeatedElementsMap.clear();
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (this.input[i][j] == '.') {
          continue;
        }

        if (this.input[i][j] < '0' || this.input[i][j] > '9' ||
            nonRepeatedElementsMap.getOrDefault(this.input[i][j], false)) {
          return false;
        }

        nonRepeatedElementsMap.putIfAbsent(this.input[i][j], true);
      }
    }

    return true;
  }

  private boolean validateColumns() {
    Map<Character, Boolean> nonRepeatedElementsMap = new HashMap<>();

    for (int i = 0; i < BOARD_SIZE; i++) {
      nonRepeatedElementsMap.clear();
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (this.input[j][i] == '.') {
          continue;
        }

        if (this.input[j][i] < '0' || this.input[j][i] > '9' ||
            nonRepeatedElementsMap.getOrDefault(this.input[j][i], false)) {
          return false;
        }

        nonRepeatedElementsMap.putIfAbsent(this.input[j][i], true);
      }
    }

    return true;
  }

  private boolean validateQuadrants() {
    List<int[]> quadrantIndexes = new ArrayList<>();
    quadrantIndexes.add(new int[]{0, 2});
    quadrantIndexes.add(new int[]{3, 5});
    quadrantIndexes.add(new int[]{6, 8});

    boolean result = true;
    Map<Character, Boolean> nonRepeatedElementsMap = new HashMap<>();

    for (int[] quadrantI : quadrantIndexes) {
      for (int[] quadrantJ : quadrantIndexes) {
        for (int i = quadrantI[0]; i <= quadrantI[1]; i++) {
          for (int j = quadrantJ[0]; j <= quadrantJ[1]; j++) {
            if (this.input[i][j] == '.') {
              continue;
            }

            if (this.input[i][j] < '0' || this.input[i][j] > '9' ||
                nonRepeatedElementsMap.getOrDefault(this.input[i][j], false)) {
              return false;
            }

            nonRepeatedElementsMap.putIfAbsent(this.input[i][j], true);
          }
        }
        nonRepeatedElementsMap.clear();
      }
    }

    return result;
  }

  private int getNumberOfQuadrant(int row, int column) {
    int quadrantRow = row / 3;
    int quadrantColumn = column / 3;

    return QUADRANT_NUMBER[quadrantRow][quadrantColumn];
  }
}
