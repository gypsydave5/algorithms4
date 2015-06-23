require 'set'

class UF
  def initialize(number_of_objects)
    @objects = (0...number_of_objects).map do |object|
      [object].to_set
    end.to_set
  end

  def union(first, second)
    first_collection = @objects.find { |coll| coll.include? first }
    second_collection = @objects.find { |coll| coll.include? second }
    new_collection = first_collection + second_collection
    @objects.delete first_collection
    @objects.delete second_collection
    @objects.add new_collection
  end

  def connected?(first, second)
    @objects.any? do |coll|
      coll.include?(first) && coll.include?(second)
    end
  end
end
