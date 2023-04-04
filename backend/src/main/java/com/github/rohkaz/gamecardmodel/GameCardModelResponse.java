package com.github.rohkaz.gamecardmodel;

import java.util.List;

public record GameCardModelResponse(
        List<GameCardModel> results
) {
}
