#pragma once

#include <SFML/Graphics.hpp>
#include <iostream>

#define Max_main_menu 4

class MainMenu
{

public: 
	
	MainMenu(float width, float height);
	void draw(sf::RenderWindow& window);
	void MoveUp();
	void MoveDown();

	int MainMenuPressed()
	{
		return MainMenuSlected;
	}
	~MainMenu();

private: 
	int MainMenuSlected;
	sf::Font font;
	sf::Text mainMenu[Max_main_menu];
};
