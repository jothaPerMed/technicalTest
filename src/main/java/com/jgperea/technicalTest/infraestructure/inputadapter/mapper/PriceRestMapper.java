package com.jgperea.technicalTest.infraestructure.inputadapter.mapper;

import com.jgperea.technicalTest.domain.model.InputRest;
import com.jgperea.technicalTest.domain.model.OutputRest;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.InputDTO;
import com.jgperea.technicalTest.infraestructure.inputadapter.rest.data.OutputDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * The interface Price rest mapper.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface PriceRestMapper {

    /**
     * To input rest input rest.
     *
     * @param inputDTO the input dto
     * @return the input rest
     */
    @Mapping(target = "fechaEntrada", source = "fechaDeAplicacion", qualifiedByName = "getFechaEntrada")
    @Mapping(target = "idProducto", source = "identificadorDeProducto")
    @Mapping(target = "idCadena", source = "identificadorDeCadena")
    InputRest toInputRest(InputDTO inputDTO);

    @Named("getFechaEntrada")
    default LocalDateTime getFechaEntrada(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss", Locale.ROOT);
        return LocalDateTime.parse(date, formatter);
    }

    /**
     * To output dto output dto.
     *
     * @param outputRest the output rest
     * @return the output dto
     */
    @Mapping(target = ".", source = ".")
    @Mapping(target = "identificadorDeCadena", source = "idCadena")
    @Mapping(target = "identificadorDeProducto", source = "idProducto")
    @Mapping(target = "fechasDeAplicacion", source = ".", qualifiedByName = "getFechasDeAplicacion")
    OutputDTO toOutputDTO(OutputRest outputRest);

    @Named("getFechasDeAplicacion")
    default List<String> getFechasDeAplicacion(OutputRest outputRest) {
        return Arrays.asList(outputRest.getFechaEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")),
                outputRest.getFechaSalida().format(DateTimeFormatter.ofPattern("yyyy" +
                        "-MM-dd-HH.mm.ss")));
    }
}
