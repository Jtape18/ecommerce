package com.josepaulo.ecommerce.interfaces.controller;

import com.josepaulo.ecommerce.application.useCases.report.GetSalesReportUseCase;
import com.josepaulo.ecommerce.domain.enums.OrderStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final GetSalesReportUseCase getSalesReportUseCase;

    @GetMapping("/sales")
    @Operation(summary = "Get total sales grouped by order status between two dates")
    public Map<OrderStatus, BigDecimal> getSalesReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return getSalesReportUseCase.execute(start, end);
    }
}
