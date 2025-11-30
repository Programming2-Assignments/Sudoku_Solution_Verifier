package org.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultCollector {
    private final List<DuplicateRecord> duplicateRows = Collections.synchronizedList(new ArrayList<>());
    private final List<DuplicateRecord> duplicateCols = Collections.synchronizedList(new ArrayList<>());
    private final List<DuplicateRecord> duplicateBoxes = Collections.synchronizedList(new ArrayList<>());

    public void addDuplicateRows(List<DuplicateRecord> duplicateRows) {
        this.duplicateRows.addAll(duplicateRows);
    }
    public void addDuplicateCols(List<DuplicateRecord> duplicateCols) {
        this.duplicateCols.addAll(duplicateCols);
    }
    public void addDuplicateBoxes(List<DuplicateRecord> duplicateBoxes) {
        this.duplicateBoxes.addAll(duplicateBoxes);
    }

    public List<DuplicateRecord> getDuplicateRows() {
        return duplicateRows;
    }
    public List<DuplicateRecord> getDuplicateCols() {
        return duplicateCols;
    }
    public List<DuplicateRecord> getDuplicateBoxes() {
        return duplicateBoxes;
    }

    public boolean isValid() {
        return duplicateRows.isEmpty()&&duplicateCols.isEmpty()&&duplicateBoxes.isEmpty();
    }

}
