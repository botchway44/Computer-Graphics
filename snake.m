function game()

%clear the screen before loadin map
clear

%creat a map
map(200,200) = logical(1);

%set a pixel in the map
x= 136; 
y=135;

%draw the player on scree
 map =  drawPixel(map,x,y,1);
 
 %display map
imshow(map);



teta = [cos(90) -sin(90) 0; sin(90) cos(90) 0; 0 0 1];
teta = teta';

direction = ""
  
%figure(gcf,'Windowkeypressfcn',@callbackfunction);

figure('KeyPressFcn',@my_callback);
    function my_callback(splooge,event)%callback function for movement
        switch event.Character
            case 'q'
                direction = "END"
            case 30               % arrow direction
               
               direction = "UP"              %up d=1
               
            case 31
               
              direction = "DOWN"          %down d=2
               
            case 29
               
                direction = "Right"           %right d=3
         
            case 28      
                direction = "LEFT"            %left d=4

        end
    end


while true
 
   map = drawPixel(map,x,y,0);
   x  = x-10;
  
   %check if at the very top 
    if x <= 0
       x = 210
    end
   
   map = drawPixel(map,x,y,1);
   
   direction
  
   
   %check for with and height constraint
   pause(0.5)
   imshow(map)
end

    
%Draw pixel function 
function map =  drawPixel(map,x,y,color)
    for i=0 : 30
        for j=0 : 2
            map(x+i,y+j) = color;
        end
    end
end

end
