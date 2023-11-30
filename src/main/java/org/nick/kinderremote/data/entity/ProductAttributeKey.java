package org.nick.kinderremote.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class ProductAttributeKey implements Serializable {
    private Long prodId;
    private Long attribId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductAttributeKey)) {
            return false;
        }
        ProductAttributeKey that = (ProductAttributeKey) o;
        return getProdId().equals(that.getProdId()) &&
                getAttribId().equals(that.getAttribId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProdId(), getAttribId());
    }
}


//@Embeddable
    // Конструкторы, геттеры, сеттеры и т.д.

    // Переопределение методов equals() и hashCode()
