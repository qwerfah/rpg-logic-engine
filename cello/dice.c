//
// Created by qwerheh on 03.07.22.
//

#include "dice.h"
#include "defines.h"

var Dice = Cello(Dice, Instance(New, Dice_New, NULL));

static struct DiceOps defaultDiceOps = { .Dice_New = Dice_New, .Dice_Throw = Dice_Throw };

void Dice_New(var self, var args) {
    struct Dice* dice = cast(self, Dice);
    dice->max = c_int(get(args, $I(0)));
    dice->ops = defaultDiceOps;
    srand(time(NULL) / 2);
}

uint8_t Dice_Throw(var self) {
    return rand() % (spcast(self, Dice)->max) + 1;
}