package br.com.clinicavt.infra.framework;

import br.com.clinicavt.infra.models.consulta.Consulta;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public final class ResponseCollectionDTO<T> {

    private final List<T> items;
    private final int size;
    private final boolean hasNext;

    private ResponseCollectionDTO(List<T> items){
        this.hasNext = false;
        this.size = items.size();
        this.items = items;
    }

    public static <T> ResponseCollectionDTO<T> of(List<T> items) {
        return new ResponseCollectionDTO<>(items);
    }

}
