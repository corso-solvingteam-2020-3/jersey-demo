package it.solvingteam.jerseydemo.controller;

import it.solvingteam.jerseydemo.dto.ErrorDto;
import it.solvingteam.jerseydemo.dto.OperationRequestDto;
import it.solvingteam.jerseydemo.dto.ResultArrayResponseDto;
import it.solvingteam.jerseydemo.dto.ResultResponseDto;
import java.util.stream.IntStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@Path("/math")
public class MathController {

    @GET
    @Path("/sum")
    @Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResultResponseDto getSum(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        ResultResponseDto resultResponseDto = new ResultResponseDto();
        resultResponseDto.setValue((double) (a + b));

        return resultResponseDto;
    }

    @POST
    @Path("/substraction")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public ResultResponseDto getSubstraction(OperationRequestDto operationRequestDto) {
        ResultResponseDto resultResponseDto = new ResultResponseDto();
        resultResponseDto.setValue((double) (operationRequestDto.getA() - operationRequestDto.getB()));

        return resultResponseDto;
    }

    @GET
    @Path("/timestable/{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public Response getTimestable(@PathParam("numero") Integer numero) {
        ResultArrayResponseDto resultArrayResponseDto = new ResultArrayResponseDto();

        IntStream.range(1, 11).forEach(i -> resultArrayResponseDto.getValues().add((double) (i * numero)));

        return Response.status(HttpStatus.UNAUTHORIZED.value()).entity(new ErrorDto("Non sei autorizzato")).build();
    }

}
