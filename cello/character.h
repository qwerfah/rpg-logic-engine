//
// Created by qwerheh on 03.07.22.
//

#ifndef RPG_LOGIC_ENGINE_CHARACTER_H
#define RPG_LOGIC_ENGINE_CHARACTER_H

#include <Cello.h>

struct Character {

    struct {
        uint8_t strength;
        uint8_t agility;
        uint8_t stamina;
        uint8_t intelligence;
        uint8_t wisdom;
        uint8_t charisma;
    } characteristics;

    // Each characteristic corresponds to its modifier. Modifiers are applied in different situations,
    // when character performs action associated with this characteristic. Each ranges between -5 and 5.
    struct {
        int8_t strength;
        int8_t agility;
        int8_t stamina;
        int8_t intelligence;
        int8_t wisdom;
        int8_t charisma;
    } modifiers;
};

var Character = Cello(Character);

struct characteristics_determining_algorithm {
    int
};

#endif //RPG_LOGIC_ENGINE_CHARACTER_H
