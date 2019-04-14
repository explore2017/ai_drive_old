package com.explore.pojo;

public class Source {
    private Integer id;

    private String sourceName;

    private String sourcePosition;

    private Float sourceValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getSourcePosition() {
        return sourcePosition;
    }

    public void setSourcePosition(String sourcePosition) {
        this.sourcePosition = sourcePosition == null ? null : sourcePosition.trim();
    }

    public Float getSourceValue() {
        return sourceValue;
    }

    public void setSourceValue(Float sourceValue) {
        this.sourceValue = sourceValue;
    }
}