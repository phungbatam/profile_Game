#pragma once
#ifndef __CONTROLGAME__

#include <iostream>
#include <SFML/Graphics.hpp>

class ControlGame
{
public:

	ControlGame()
	{

	};

	// Button Control Game With Skill 
	ControlGame(std::string t, sf::Vector2f size, sf::Color bgColor, sf::Color TxtColor,int charSize)
	{

		textSkill.setString(t);
		textSkill.setFillColor(TxtColor);
		textSkill.setCharacterSize(charSize);

		btnControlGame.setSize(size);
		btnControlGame.setFillColor(bgColor);

	}

	void setFont(sf::Font &font)
	{
		textSkill.setFont(font);
	}

	void setBackgroundColor(sf::Color color)
	{
		btnControlGame.setFillColor(color);
	}

	void setTxtColor(sf::Color color)
	{
		textSkill.setFillColor(color);
	}
	
	void setPostion(sf::Vector2f pos)
	{
		btnControlGame.setPosition(pos);

		float xPos = (pos.x + btnControlGame.getGlobalBounds().width / 2 - (textSkill.getGlobalBounds().width / 2));
		float yPos = (pos.y + btnControlGame.getGlobalBounds().height / 2 - (textSkill.getGlobalBounds().height / 2));

		textSkill.setPosition({ xPos, yPos });
	}

	void drawTo(sf::RenderWindow &window)
	{
		window.draw(btnControlGame);
		window.draw(textSkill);
	}

	bool isMouseOver(sf::RenderWindow &window)
	{
		float mouseX = sf::Mouse::getPosition(window).x;
		float mouseY = sf::Mouse::getPosition(window).y;

		float btnPosX = btnControlGame.getPosition().x;
		float btnPosY = btnControlGame.getPosition().y;

		float btnxPosWidth = btnControlGame.getPosition().x + btnControlGame.getLocalBounds().width;
		float btnyPosHeight = btnControlGame.getPosition().y + btnControlGame.getLocalBounds().height;

		if (mouseX < btnxPosWidth && mouseX > btnPosX && mouseY < btnyPosHeight && mouseY > btnPosY)
		{
			return true;
		}

		return false;
	}

private: 
	
	// RectangleShape Create btnControlGame
	sf::RectangleShape btnControlGame;
	sf::Text textSkill;

};

#endif		