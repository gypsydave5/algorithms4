class QuickFindUF

  def initialize(number_of_objects)
    @id = (0...number_of_objects).to_a
  end

  def connected?(first, second)
    @id[first] == @id[second]
  end

  def union(first, second)
    first_id = @id[first]
    second_id = @id[second]
    @id.map! do |object|
      next second_id if object == first_id
      object
    end
  end
end
