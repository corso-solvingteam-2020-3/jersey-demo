package it.solvingteam.jerseydemo.controller;

import it.solvingteam.jerseydemo.dto.OperationRequestDto;
import it.solvingteam.jerseydemo.dto.ResultArrayResponseDto;
import it.solvingteam.jerseydemo.dto.ResultResponseDto;
import java.util.stream.IntStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

@Component
@Path("/math")
public class MathController {

    @GET
    @Path("/sum")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultResponseDto getSum(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        ResultResponseDto resultResponseDto = new ResultResponseDto();
        resultResponseDto.setValue((double) (a + b));

        return resultResponseDto;
    }

    @POST
    @Path("/substraction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultResponseDto getSubstraction(OperationRequestDto operationRequestDto) {
        ResultResponseDto resultResponseDto = new ResultResponseDto();
        resultResponseDto.setValue((double) (operationRequestDto.getA() - operationRequestDto.getB()));

        return resultResponseDto;
    }

    @GET
    @Path("/timestable/{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultArrayResponseDto getSubstraction(@PathParam("numero") Integer numero) {
        ResultArrayResponseDto resultArrayResponseDto = new ResultArrayResponseDto();

        IntStream.range(1, 11).forEach(i -> resultArrayResponseDto.getValues().add((double) (i * numero)));

        return resultArrayResponseDto;
    }

}
