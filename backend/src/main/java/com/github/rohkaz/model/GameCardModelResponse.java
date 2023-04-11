package com.github.rohkaz.model;

import java.util.List;

public record GameCardModelResponse(
        List<GameCardModel> results
) {
}
