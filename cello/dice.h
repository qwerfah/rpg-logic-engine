//
// Created by qwerheh on 03.07.22.
//

#ifndef RPG_LOGIC_ENGINE_DICE_H
#define RPG_LOGIC_ENGINE_DICE_H

#include <Cello.h>

void Dice_New(var self, var args);

uint8_t Dice_Throw(var self);

struct DiceOps {
    void (*Dice_New)(var self, var args);
    uint8_t (*Dice_Throw)(var self);
};

struct Dice {
    uint8_t max;
    struct DiceOps ops;
};

extern var Dice;

#endif //RPG_LOGIC_ENGINE_DICE_H
